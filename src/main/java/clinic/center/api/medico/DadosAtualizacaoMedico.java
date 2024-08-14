package clinic.center.api.medico;

import clinic.center.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {
}
