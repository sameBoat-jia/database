<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/company">
        <ul>
            <xsl:for-each select="dept">
                <xsl:for-each select="emp">
                    <xsl:choose>
                        <xsl:when test="sal&lt;500 or sal=0">
                            <li>
                                <xsl:value-of
                                        select="concat(@empno,'-',@job,' name:',ename,' birthday:',hiredate,' salary:',sal)"/>
                            </li>
                        </xsl:when>
                    </xsl:choose>
                </xsl:for-each>
            </xsl:for-each>
        </ul>
    </xsl:template>
</xsl:stylesheet>