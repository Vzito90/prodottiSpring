package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MyControl {
	
	ArrayList<Prodotto> lista = new ArrayList<>();
	@GetMapping("/")
	public String getForm() {
		return "form";
	}
	@PostMapping("/submit")
	public String submit(@RequestParam("nome") String nome, @RequestParam("marca") String marca, 
			@RequestParam("prezzo") double prezzo, @RequestParam("url") String url, Model model) {
		
		Prodotto p1 = new Prodotto();
		p1.setNome(nome);
		p1.setMarca(marca);
		p1.setPrezzo(prezzo);
		p1.setUrl(url);
		lista.add(p1);		
		model.addAttribute("nome", nome);
		
		return "form";
	}
	
	@GetMapping("/mostra")
	public String getProdotto(Model model) {
		model.addAttribute("lista", lista);
		return "mostra";
	}

}
