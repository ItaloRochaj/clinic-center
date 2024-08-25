package clinic.center.api.domain.cancelamento;

import clinic.center.api.controller.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}