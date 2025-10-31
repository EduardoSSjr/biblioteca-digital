package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.BibliotecaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LivroController {

    private final BibliotecaService service;

    public LivroController(BibliotecaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        List<Livro> livros = service.listarLivros();
        model.addAttribute("livros", livros);
        return "livros";
    }

    @GetMapping("/cadastrar")
    public String formCadastrar() {
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(@RequestParam String titulo, @RequestParam String autor) {
        service.cadastrarLivro(titulo, autor);
        return "redirect:/livros";
    }

    @GetMapping("/emprestar")
    public String formEmprestar(Model model) {
        model.addAttribute("livros", service.listarLivrosDisponiveis());
        return "emprestar";
    }

    @PostMapping("/emprestar")
    public String emprestarLivro(@RequestParam int idLivro, @RequestParam String nomeUsuario) {
        service.emprestarLivro(idLivro, nomeUsuario);
        return "redirect:/livros";
    }

    @PostMapping("/devolver")
    public String devolverLivro(@RequestParam int idLivro) {
        service.devolverLivro(idLivro);
        return "redirect:/livros";
    }
}
