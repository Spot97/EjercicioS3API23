package com.example.ejercicios3api23.api;
import com.example.ejercicios3api23.model.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioAPI {

    @GET("users")
    Call<List<Usuarios>> getAllUsuarios();
}