package clinic.center.api.domain.consulta.validacoes.agendamento;

import clinic.center.api.domain.ValidacaoException;
import clinic.center.api.domain.consulta.ConsultaRepository;
import clinic.center.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        // Verifique se o nome e a assinatura do método são corretos
        boolean medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(),dados.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Medico já possui outra consulta agendada no mesmo horário");
        }
    }
}
