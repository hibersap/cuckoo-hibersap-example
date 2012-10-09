package de.akquinet.jbosscc.cuckoo.example.conversion;

import de.akquinet.jbosscc.cuckoo.example.model.Severity;
import org.hibersap.conversion.ConversionException;
import org.hibersap.conversion.Converter;

public class SeverityConverter implements Converter<Severity, String>
{
    public Severity convertToJava( String sapValue ) throws ConversionException
    {
        return Severity.fromSapType( sapValue.charAt( 0 ) );
    }

    public String convertToSap( Severity javaValue ) throws ConversionException
    {
        throw new UnsupportedOperationException( "The parameter should never be passed back to SAP" );
    }
}
