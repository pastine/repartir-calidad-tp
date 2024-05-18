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

    @Entonces("no debería crear el grupo con un total de gastos negativo")
    public void noDeberiaCrearElGrupoConUnUnicoMiembro() {
      assertThat( this.grupo.estaFormado() ).isFalse();
    }
}
