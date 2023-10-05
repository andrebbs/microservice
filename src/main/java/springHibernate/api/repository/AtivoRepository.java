package springHibernate.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springHibernate.api.entities.Ativo;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {
    // Métodos de consulta personalizados, se necessário
}

