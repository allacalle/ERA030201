package net.allacalle.android.era030.Test.TestResultados;

import android.content.Context;
import android.test.InstrumentationTestCase;

import net.allacalle.android.era030.Formula;

/**
 * Created by Alfonso on 04/05/2016.
 */
public class TestResultadosGlasgow extends InstrumentationTestCase
{
    public void testResultadoGlasgow () throws Exception
    {
        String expected = "";
        String reality = "" ;
        String idFormula ="";
        //Clave de la formula Child Pugh
        idFormula = "2";
        //IMPORTANTE como llamar al contexto desde el TEST
        Context context = this.getInstrumentation().getTargetContext().getApplicationContext();
        final Formula formulaActual = new Formula(idFormula, context);


        //Asignamos los valores que se han introducido por la pantalla

        //Que usan el siguiente vector. 4;33;2;12;13
        String vectorResultados [] = new String[3];
        vectorResultados[0] = "19";
        vectorResultados[1] = "25";
        vectorResultados[2] = "31";


        formulaActual.introducirValoresFormula(vectorResultados);

        formulaActual.calcularFormula();

        expected = "Traumatismo craneoencefalico moderado." ;
        reality = formulaActual.getResultado().getValor() ;

        assertEquals(expected, reality);


        float expectedNumber = 10;
        float realityNumber = formulaActual.getResultado().getPuntuacionEscala() ;

        assertEquals(expectedNumber, realityNumber);
    }
}
