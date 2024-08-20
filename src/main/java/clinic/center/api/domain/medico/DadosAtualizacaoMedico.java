package clinic.center.api.domain.medico;

import clinic.center.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {
}
