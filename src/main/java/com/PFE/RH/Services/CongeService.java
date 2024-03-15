package com.PFE.RH.Services;

import com.PFE.RH.DTO.CongeDTO;
import com.PFE.RH.Entities.Conge;
import com.PFE.RH.Mappers.CongeMapper;
import com.PFE.RH.Repositories.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CongeService {

    @Autowired
    private CongeRepository congeRepository;

    @Autowired
    private CongeMapper congeMapper;

    public CongeDTO saveConge(CongeDTO congeDTO) {
        Conge conge = congeMapper.congeDTOToConge(congeDTO);
        Conge savedConge = congeRepository.save(conge);
        return congeMapper.congeToCongeDTO(savedConge);
    }

    public CongeDTO getCongeById(Long congeId) {
        Optional<Conge> congeOptional = congeRepository.findById(congeId);
        return congeOptional.map(congeMapper::congeToCongeDTO).orElse(null);
    }

    public CongeDTO updateConge(Long congeId, CongeDTO updatedCongeDTO) {
        Optional<Conge> congeOptional = congeRepository.findById(congeId);
        if (congeOptional.isPresent()) {
            Conge conge = congeOptional.get();
            conge.setStartDate(updatedCongeDTO.getStartDate());
            conge.setEndDate(updatedCongeDTO.getEndDate());
            conge.setState(updatedCongeDTO.getState());
            congeRepository.save(conge);
            return congeMapper.congeToCongeDTO(conge);
        }
        return null;
    }
    public List<CongeDTO> getAllConges() {
        List<Conge> conges = congeRepository.findAll();
        return conges.stream()
                .map(congeMapper::congeToCongeDTO)
                .collect(Collectors.toList());
    }
    public boolean deleteConge(Long congeId) {
        Optional<Conge> congeOptional = congeRepository.findById(congeId);
        if (congeOptional.isPresent()) {
            congeRepository.deleteById(congeId);
            return true;
        }
        return false;
    }
}
