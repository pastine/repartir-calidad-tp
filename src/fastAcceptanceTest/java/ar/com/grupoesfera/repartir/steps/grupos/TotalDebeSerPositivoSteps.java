package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import java.math.BigDecimal;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalDebeSerPositivoSteps extends FastCucumberSteps {

    private Grupo grupo;

    @Cuando("el usuario intenta crear un grupo con un total de gastos negativo")
    public void elUsuarioIntentaCrearUnGrupoConUnTotalDeGastosNegativo() {
        List<String> miembros = new LinkedList<String>();
        miembros.add( "Oscar" );
        miembros.add( "Miguel" );

        grupo = new Grupo();
        grupo.setMiembros( miembros );
        grupo.setTotal(new BigDecimal(-10));
    }

    @Cuando("el usuario tiene un grupo valido")
    public void elUsuarioTieneUnGrupoValido() {
        List<String> miembros = new LinkedList<String>();
        miembros.add( "Oscar" );
        miembros.add( "Miguel" );

        grupo = new Grupo();
        grupo.setMiembros( miembros );
        grupo.setTotal(new BigDecimal(10));
    }

    @Cuando("luego cambia el total de gastos a negativo")
    public void elUsuarioCambiaElTotalDeGastosANegativo() {
        this.grupo.setTotal(new BigDecimal(-10));
    }

    @Cuando("el usuario intenta crear un grupo con un total de gastos en 0")
    public void elUsuarioIntentaCrearUnGrupoConUnTotalDeGastosEn0() {
        List<String> miembros = new LinkedList<String>();
        miembros.add( "Oscar" );
        miembros.add( "Miguel" );

        grupo = new Grupo();
        grupo.setMiembros( miembros );
        grupo.setTotal(new BigDecimal(0));
    }

    @Entonces("no debería crear el grupo con un total de gastos negativo")
    public void noDeberíaCrearElGrupoConUnTotalDeGastosNegativo() {
      assertThat( this.grupo.estaFormado() ).isFalse();
    }

    @Entonces("no debería poder crear el grupo")
    public void noDeberíaPoderCrearElGrupo() {
      assertThat( this.grupo.estaFormado() ).isFalse();
    }
}
