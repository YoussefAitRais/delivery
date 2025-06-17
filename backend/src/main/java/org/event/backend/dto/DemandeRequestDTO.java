package org.event.backend.dto;

import lombok.Data;

@Data
public class DemandeRequestDTO {

    private Long trajetId;
    private Long expediteurId;

    private ColisDTO colis; // الطرد المرتبط بهاد الطلب
}
