package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.auth.AuthResponse;
import com.llamaboard.cliente.backend.apirest.auth.LoginRequest;
import com.llamaboard.cliente.backend.apirest.models.repository.IUsuarioRepository;
import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import com.google.gson.JsonObject;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioDao;
    private final String URLAuthRegister = "http://localhost:8081/auth/register";
    private final String URLAuthLogin = "http://localhost:8081/auth/login";


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public AuthResponse crear(Usuario usuario) {

        Usuario newUser = new Usuario();
        newUser.setId(null);
        newUser.setNombre(usuario.getNombre());
        newUser.setApellido(usuario.getApellido());
        newUser.setPassword(usuario.getPassword());
        newUser.setEmail(usuario.getEmail());
        newUser.setTipoUsuario(false);
        usuarioDao.save(newUser);


        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", usuario.getNombre());
        jsonObject.addProperty("lastName",usuario.getApellido());
        jsonObject.addProperty("username",usuario.getEmail());
        jsonObject.addProperty("password",usuario.getPassword());
        jsonObject.addProperty("role",false);

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLAuthRegister))
                .header("Content-Type", "application/json") // Establecer el tipo de contenido del cuerpo de la solicitud
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString())) // Utilizar el JSON generado como String
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int lenghtOfResponse = response.body().length() - 1;
            String responseBody = response.body().substring(9, lenghtOfResponse).replace("\"", "");

            return new AuthResponse(responseBody);

        } catch (Exception e) {
            System.out.println("Error POST: Registro");
            e.printStackTrace();
        }

        throw new RuntimeException("Error POST: Registro");
    }

    @Override
    public AuthResponse verificar(LoginRequest loginRequest) throws AuthenticationException {
        if (!isUserCredentialsValid(loginRequest.getUsername(), loginRequest.getPassword())) {
            throw new AuthenticationException("Credenciales inválidas");
        }

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("username",loginRequest.getUsername());
        jsonObject.addProperty("password",loginRequest.getPassword());

        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URLAuthLogin))
                .header("Content-Type", "application/json") // Establecer el tipo de contenido del cuerpo de la solicitud
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString())) // Utilizar el JSON generado como String
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int lenghtOfResponse = response.body().length() - 1;
            String responseBody = response.body().substring(9, lenghtOfResponse).replace("\"", "");

            return new AuthResponse(responseBody);

        } catch (Exception e) {
            System.out.println("Error al enviar la solicitud POST");
            e.printStackTrace();
        }

        throw new RuntimeException("Error al enviar la solicitud POST");
    }

    private boolean isUserCredentialsValid(String username, String password) {
        Optional<Usuario> user = usuarioDao.findByEmailAndPassword(username, password);
        return user.isPresent();
    }

}
