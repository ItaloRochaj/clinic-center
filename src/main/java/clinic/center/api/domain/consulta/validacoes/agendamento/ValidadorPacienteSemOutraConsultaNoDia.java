package clinic.center.api.domain.consulta.validacoes.agendamento;

import clinic.center.api.domain.ValidacaoException;
import clinic.center.api.domain.consulta.Consulta;
import clinic.center.api.domain.consulta.ConsultaRepository;
import clinic.center.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        Consulta consulta = repository.getConsultaComPacienteComConsultaAgendadaNoDia(dados.pacienteId(), dados.data());

        if (consulta != null) {
            throw new ValidacaoException("Paciente já possui consulta marcada no dia");
        }
    }
}
