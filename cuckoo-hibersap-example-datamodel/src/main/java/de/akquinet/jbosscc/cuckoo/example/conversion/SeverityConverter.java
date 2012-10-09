package de.akquinet.jbosscc.cuckoo.example.conversion;

import de.akquinet.jbosscc.cuckoo.example.model.Severity;
import org.hibersap.conversion.ConversionException;
import org.hibersap.conversion.Converter;

public class SeverityConverter implements Converter
{
    public Severity convertToJava( Object sapValue ) throws ConversionException
    {
        String sapType = ( String ) sapValue;
        return Severity.fromSapType( sapType.charAt( 0 ) );
    }

    public String convertToSap( Object javaValue ) throws ConversionException
    {
        throw new UnsupportedOperationException( "The parameter should never be passed back to SAP" );
    }
}
