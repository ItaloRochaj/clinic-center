package clinic.center.api.domain.consulta.validacoes.agendamento;

import clinic.center.api.domain.ValidacaoException;
import clinic.center.api.domain.consulta.DadosAgendamentoConsulta;
import clinic.center.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void  validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw  new ValidacaoException("consulta nao pode ser agendada com medico excluido");
        }
    }
}
