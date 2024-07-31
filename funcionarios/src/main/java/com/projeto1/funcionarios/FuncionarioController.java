package com.projeto1.funcionarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodos(){
        return funcionarioService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioService.buscarPorId(id));
    }
   @GetMapping("/departamento")
    public List<Funcionario> buscarPorDepartamento(@RequestParam String departamento){
        return funcionarioService.buscarPorDepartamento(departamento);
    }
    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.salvar(funcionario));
    }
    @PostMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar (@PathVariable long id, @RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.atualizar(id, funcionario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
