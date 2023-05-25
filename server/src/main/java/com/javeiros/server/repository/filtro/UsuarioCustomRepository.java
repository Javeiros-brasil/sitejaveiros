package com.javeiros.server.repository.filtro;

import com.javeiros.server.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsuarioCustomRepository {

    private final EntityManager entityManager;

    public UsuarioCustomRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }


    public List<Usuario> filtroUsuario(List<String> nomeArea, String nomeUsuario) {
        String query = "SELECT u FROM Usuario u JOIN u.areas s WHERE 1 = 1";

        if (nomeUsuario != null) {
            query += " AND u.nomeUsuario LIKE CONCAT('%', :nomeUsuario, '%')";
        }

        if (nomeArea != null && !nomeArea.isEmpty()) {
            query += " AND s.nomeArea in :nomeArea";
        }

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(query, Usuario.class);

        if (nomeUsuario != null) {
            typedQuery.setParameter("nomeUsuario", nomeUsuario);
        }

        if (nomeArea != null && !nomeArea.isEmpty()) {
            typedQuery.setParameter("nomeArea", nomeArea );
        }


        return typedQuery.getResultList();


    }

}
