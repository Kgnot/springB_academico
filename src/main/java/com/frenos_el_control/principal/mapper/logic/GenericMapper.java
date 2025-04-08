package com.frenos_el_control.principal.mapper.logic;

public interface GenericMapper <G,D>{
    D toDTO(G g);
    G toEntity(D d);
}
