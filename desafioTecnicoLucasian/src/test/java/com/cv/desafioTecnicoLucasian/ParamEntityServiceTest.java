package com.cv.desafioTecnicoLucasian;

import com.cv.desafioTecnicoLucasian.entities.ParamEntity;
import com.cv.desafioTecnicoLucasian.repositories.params.ParamRepository;
import com.cv.desafioTecnicoLucasian.services.params.ParamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ParamEntityServiceTest {

    @Mock
    private ParamRepository paramRepository;

    @InjectMocks
    private ParamServiceImpl paramServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll(){
        UUID dynamicUUID = UUID.randomUUID();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        ParamEntity paramEntity1 = new ParamEntity(dynamicUUID, "Param1", "Valor1", "lorem", now, now);
        ParamEntity paramEntity2 = new ParamEntity(dynamicUUID, "Param2", "Valor2", "lorem ipsu", now, now);
        when(paramRepository.findAll()).thenReturn(Arrays.asList(paramEntity1, paramEntity2));

        List<ParamEntity> paramEntities = paramServiceImpl.findAll();


        // 1. Validar que no sea nulo
        assertNotNull(paramEntity1.getParamId(), "El UUID no debe ser nulo");

        // 2. Validar que sea un UUID en formato correcto
        assertTrue(isValidUUID(paramEntity1.getParamId().toString()), "El UUID debe estar en un formato válido");

        // Método para verificar el formato del UUID


        assertEquals(dynamicUUID,
                paramEntity1.getParamId());
        verify(paramRepository, times(1)).findAll();
    }

    private boolean isValidUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
