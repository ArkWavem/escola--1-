package com.senai.escola.Service;

import com.senai.escola.Interface.ProfessorRepository;
import com.senai.escola.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository _repository;

    public ProfessorService(ProfessorRepository repository) {
        this._repository = repository;
    }

    public List<Professor> buscarProfessores() {
        return _repository.findAll();
    }

    public Professor salvarProfessor(Professor professor) {
        return _repository.save(professor);
    }

    public void excluirProfessor(Long id) {
        _repository.deleteById(id);
    }

    public Professor buscarProfessorId(Long id) {
        return _repository.findById(id).orElse(null);
    }
}