package clinic.center.api.domain.consulta;

import clinic.center.api.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(value = """
            select c.* from consulta c
            where c.paciente_id = :pacienteId
            and DATE(c.data) = DATE(:data)
            and c.status != "CANCELADA"
            order by rand()
            limit 1
            """, nativeQuery = true)
    Consulta getConsultaComPacienteComConsultaAgendadaNoDia(Long pacienteId, LocalDateTime data);

    Boolean existsByMedicoIdAndDataAndMotivoIsNull(Long medicoId, LocalDateTime data);

}