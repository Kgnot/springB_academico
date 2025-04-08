package com.frenos_el_control.principal.dto.response;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T>{

    private T content;

}
