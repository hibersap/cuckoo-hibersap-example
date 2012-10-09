package de.akquinet.jbosscc.cuckoo.example.model;

public enum Severity
{
    INFO( 'I' ), SUCCESS( 'S' ), WARNING( 'W' ), ERROR( 'E' ), ABORT( 'A' ), OTHER( ' ' );

    private char sapType;

    Severity( char sapType )
    {
        this.sapType = sapType;
    }

    public static Severity fromSapType( char sapType )
    {
        for ( Severity severity : Severity.values() )
        {
            if ( severity.sapType == sapType )
            {
                return severity;
            }
        }
        return OTHER;
    }
}
