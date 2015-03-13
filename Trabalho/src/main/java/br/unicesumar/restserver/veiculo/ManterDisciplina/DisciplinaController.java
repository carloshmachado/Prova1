
package br.unicesumar.restserver.veiculo.ManterDisciplina;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/disciplina")
@Transactional
public class DisciplinaController {
    @Autowired
    private EntityManager em;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Disciplina> getDisciplina(){
        
        return em.createQuery("from Disciplina").getResultList();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criarDisciplina(@RequestParam Long id, @RequestParam String nome, @RequestParam Integer cargaHoraria, @RequestParam Integer peso){
        Disciplina nova = new Disciplina(id, nome, cargaHoraria, peso);
        em.persist(nova);
    }
    
    
}
