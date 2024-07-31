package com.projeto1.funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }
    public Funcionario buscarPorId(long id){
        return funcionarioRepository.findById(id).orElseThrow();
    }
    public List<Funcionario> buscarPorDepartamento(String departamento){
        return funcionarioRepository.findByDepartamento(departamento);
    }
    public Funcionario salvar (Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado){
        Funcionario funcionario = buscarPorId(id);
        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setCargo(funcionarioAtualizado.getCargo());
        funcionario.setDepartamento(funcionarioAtualizado.getDepartamento());
        funcionario.setSalario(funcionarioAtualizado.getSalario());
        return funcionarioRepository.save(funcionario);
    }

    public void excluir(Long id){
        funcionarioRepository.deleteById(id);
    }
}
