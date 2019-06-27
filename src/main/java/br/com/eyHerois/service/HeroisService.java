package br.com.eyHerois.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 

import br.com.eyHerois.model.EyHeroisModel;
import br.com.eyHerois.model.ResponseModel;
import br.com.eyHerois.repository.EyHeroisRepository;

@RestController
@RequestMapping("/service")
public class HeroisService {
	
	private EyHeroisRepository eyHeroiRepository;
	
	public HeroisService(EyHeroisRepository eyHeroiRepository) {
		this.eyHeroiRepository = eyHeroiRepository;
	}

	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param eyHeroi
	 * @return
	 */
	@RequestMapping(value="/eyHeroi", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody EyHeroisModel eyHeroi){
 
		try {
 
			this.eyHeroiRepository.save(eyHeroi);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		} catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
	
	/**
	 * ATUALIZAR O REGISTRO DE UM HEROI
	 * @param eyHeroi
	 * @return
	 */
	@RequestMapping(value="/eyHeroi/{id}", method = RequestMethod.PATCH, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody EyHeroisModel eyHeroi){
 
		try {
 
			this.eyHeroiRepository.save(eyHeroi);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		} catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	
	/**
	 * CONSULTAR TODOS OS HEROIS
	 * @return
	 */
	@RequestMapping(value="/eyHeroi", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<EyHeroisModel> consultar(){
 
		return this.eyHeroiRepository.findAll();
	}
 
	/**
	 * BUSCAR UM HEROI PELO ID
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/eyHeroi/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody EyHeroisModel buscar(@PathVariable("id") Integer id){
 
		return this.eyHeroiRepository.findById(id);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO ID
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/eyHeroi/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		EyHeroisModel eyHeroiModel = eyHeroiRepository.findById(id);
 
		try {
 
			eyHeroiRepository.delete(eyHeroiModel);
 
			return new ResponseModel(1, "Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
}
