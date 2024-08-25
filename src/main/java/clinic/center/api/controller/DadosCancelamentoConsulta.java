package clinic.center.api.controller;

import clinic.center.api.domain.cancelamento.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}
