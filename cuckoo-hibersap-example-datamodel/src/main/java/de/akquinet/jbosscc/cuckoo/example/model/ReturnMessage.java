package de.akquinet.jbosscc.cuckoo.example.model;

import de.akquinet.jbosscc.cuckoo.example.conversion.SeverityConverter;
import org.hibersap.annotations.BapiStructure;
import org.hibersap.annotations.Convert;
import org.hibersap.annotations.Parameter;

@BapiStructure
public class ReturnMessage
{
    @Parameter( "MESSAGE" )
    private String message;

    @Parameter( "TYPE" )
    @Convert( converter = SeverityConverter.class )
    private Severity severity;

    public ReturnMessage()
    {
    }

    public String getMessage()
    {
        return message;
    }

    public Severity getSeverity()
    {
        return severity;
    }
}
