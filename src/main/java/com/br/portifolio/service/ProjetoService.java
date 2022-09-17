package com.br.portifolio.service;
import com.br.portifolio.entity.Projeto;
import com.br.portifolio.entity.StatusProjetoEnum;
import com.br.portifolio.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
@Service
public class ProjetoService {

        @Autowired
        private ProjetoRepository projetoRepository;

        public Projeto findById(Long id){
            return this.projetoRepository.findById(id).orElse(new Projeto());
        }

        public Page<Projeto> listAll(Pageable pageable){
            return this.projetoRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        }

        @Transactional
        public void insert(Projeto projeto){
            this.projetoRepository.save(projeto);
        }
        @Transactional
        public void update (Long id, Projeto projeto){
            if (id == projeto.getId()){
                this.projetoRepository.save(projeto);
            }
            else{
                throw new RuntimeException();
            }
        }

    public void deleteById(Long idProjeto, Projeto projeto) {
        if (projetoRepository.existsById(idProjeto)) {
            if (projeto.getStatus() != StatusProjetoEnum.iniciado)
            projetoRepository.deleteById(idProjeto);
        }else{
            throw new RuntimeException("O projeto nao pode ser excluido, pois ja foi iniciado");
        }
    }

}
