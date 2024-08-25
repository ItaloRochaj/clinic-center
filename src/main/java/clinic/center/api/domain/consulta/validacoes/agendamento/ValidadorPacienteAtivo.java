package clinic.center.api.domain.consulta.validacoes.agendamento;

import clinic.center.api.domain.ValidacaoException;
import clinic.center.api.domain.consulta.DadosAgendamentoConsulta;
import clinic.center.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta nao pode ser agendada com paciente exlcuido");
        }
    }
}
