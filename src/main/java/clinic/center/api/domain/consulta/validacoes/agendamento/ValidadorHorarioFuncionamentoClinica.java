package clinic.center.api.domain.consulta.validacoes.agendamento;

import clinic.center.api.domain.ValidacaoException;
import clinic.center.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

        public void validar(DadosAgendamentoConsulta dados) {
            var dataConsulta = dados.data();

            var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
            var antesDaAberturaDaClinica = dataConsulta.getHour() < 8;
            var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 17;

            if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
                throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
            }
        }
}