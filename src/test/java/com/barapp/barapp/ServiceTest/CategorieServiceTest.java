import com.barapp.barapp.Model.Entity.Categorie;
import com.barapp.barapp.Dto.CategorieDto;
import com.barapp.barapp.Repository.CategorieRepository;
import com.barapp.barapp.Service.impl.CategorieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategorieServiceTest {

    @InjectMocks
    CategorieService categorieService;

    @Mock
    CategorieRepository categorieRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        when(categorieRepository.findAll()).thenReturn(Arrays.asList(new Categorie()));
        assertEquals(1, categorieService.getAll().size());
    }

    @Test
    public void testGetOneById() {
        when(categorieRepository.findById(1)).thenReturn(Optional.of(new Categorie()));
        assertNotNull(categorieService.getOneById(1));
    }

    @Test
    public void testSave() {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setNom("Test");

        when(categorieRepository.save(any(Categorie.class))).thenReturn(new Categorie());

        Categorie result = categorieService.save(categorieDto);

        assertNotNull(result);
        verify(categorieRepository, times(1)).save(any(Categorie.class));
    }

    @Test
    public void testDeleteById() {
        doNothing().when(categorieRepository).deleteById(1);
        assertTrue(categorieService.deleteById(1));
    }
}