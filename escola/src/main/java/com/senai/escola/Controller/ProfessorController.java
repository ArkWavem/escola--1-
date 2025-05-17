package com.senai.escola.Controller;

import com.senai.escola.Service.ProfessorService;
import com.senai.escola.model.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> listaDeProfessores() {
        return professorService.buscarProfessores();
    }

    @GetMapping("/{id}")
    public Professor buscarProfessor(@PathVariable Long id) {
        return professorService.buscarProfessorId(id);
    }

    @PostMapping
    public Professor criarProfessor(@RequestBody Professor professor) {
        return professorService.salvarProfessor(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professorAlterado) {
        Professor professorExistente = professorService.buscarProfessorId(id);
        if (professorExistente == null) return null;

        professorExistente.setNomeProfessor(professorAlterado.getNomeProfessor());
        professorExistente.setEmailProfessor(professorAlterado.getEmailProfessor());
        professorExistente.setTelefoneProfessor(professorAlterado.getTelefoneProfessor());
        professorExistente.setDisciplinaProfessor(professorAlterado.getDisciplinaProfessor());

        return professorService.salvarProfessor(professorExistente);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        professorService.excluirProfessor(id);
    }
}