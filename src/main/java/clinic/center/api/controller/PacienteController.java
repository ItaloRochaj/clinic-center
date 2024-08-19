package clinic.center.api.controller;

import clinic.center.api.medico.DadosListagemMedico;
import clinic.center.api.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastroPaciente(@Valid @RequestBody DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));


    }
    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
     return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dados){

        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();

    }
}

