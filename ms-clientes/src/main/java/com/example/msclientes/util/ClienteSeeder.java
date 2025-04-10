package com.example.msclientes.util;

import com.example.msclientes.entity.Cliente;
import com.example.msclientes.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClienteSeeder implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public ClienteSeeder(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) {
        if (clienteRepository.count() == 0) {
            Cliente cliente1 = new Cliente(null, "Juan", "Pérez", "12345678", "juan.perez@gmail.com", "987654321", LocalDateTime.now().minusDays(1));
            Cliente cliente2 = new Cliente(null, "María", "Gonzales", "87654321", "maria.gonzales@hotmail.com", "912345678", LocalDateTime.now().minusDays(2));
            Cliente cliente3 = new Cliente(null, "Carlos", "Ramírez", "11223344", "carlos.ramirez@yahoo.com", "998877665", LocalDateTime.now().minusDays(3));
            Cliente cliente4 = new Cliente(null, "Lucía", "Fernández", "44332211", "lucia.fernandez@outlook.com", "934567890", LocalDateTime.now().minusDays(4));
            Cliente cliente5 = new Cliente(null, "José", "Castillo", "55667788", "jose.castillo@gmail.com", "901234567", LocalDateTime.now().minusDays(5));

            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);
            clienteRepository.save(cliente3);
            clienteRepository.save(cliente4);
            clienteRepository.save(cliente5);

            System.out.println("✅ Clientes insertados correctamente.");
        } else {
            System.out.println("⚠️ Ya existen clientes en la base de datos.");
        }
    }
}
