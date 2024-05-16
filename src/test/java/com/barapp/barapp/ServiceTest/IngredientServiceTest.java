package com.barapp.barapp.ServiceTest;

import com.barapp.barapp.Dto.IngredientDto;
import com.barapp.barapp.Model.Entity.Ingredient;
import com.barapp.barapp.Repository.IngredientRepository;
import com.barapp.barapp.Service.impl.IngredientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class IngredientServiceTest {

    @InjectMocks
    private IngredientService ingredientService;

    @Mock
    private IngredientRepository ingredientRepository;

    @Test
    public void whenSaveIngredient_thenIngredientShouldBeSaved() {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setNom("Tomate");

        Ingredient ingredient = new Ingredient();
        ingredient.setNom(ingredientDto.getNom());

        when(ingredientRepository.save(any(Ingredient.class))).thenReturn(ingredient);

        Ingredient created = ingredientService.save(ingredientDto);

        assertThat(created.getNom()).isSameAs(ingredientDto.getNom());
        verify(ingredientRepository, times(1)).save(any(Ingredient.class));
    }

    @Test
    public void whenGetAll_thenReturnAllIngredients() {
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();

        List<Ingredient> allIngredients = Arrays.asList(ingredient1, ingredient2);

        when(ingredientRepository.findAll()).thenReturn(allIngredients);

        List<Ingredient> ingredients = ingredientService.getAll();

        assertThat(ingredients).hasSize(2).extracting(Ingredient::getNom).containsOnly(ingredient1.getNom(), ingredient2.getNom());
    }

    @Test
    public void whenGetOneById_thenReturnIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Tomate");

        when(ingredientRepository.findById(1)).thenReturn(Optional.of(ingredient));

        Optional<Ingredient> found = ingredientService.getOneById(1);

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getNom()).isEqualTo(ingredient.getNom());
    }

    @Test
    public void whenDeleteById_thenIngredientShouldBeDeleted() {
        doNothing().when(ingredientRepository).deleteById(1);

        Boolean isDeleted = ingredientService.deleteById(1);

        assertThat(isDeleted).isTrue();
        verify(ingredientRepository, times(1)).deleteById(1);
    }
}