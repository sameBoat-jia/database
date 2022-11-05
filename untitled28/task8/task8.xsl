<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/company">
        <ul>
            <xsl:for-each select="dept">
                <xsl:sort select="emp/sal" data-type="number"/>
                <xsl:for-each select="emp">
                    <xsl:choose>
                        <xsl:when test="sal&lt;1000">
                            <li>
                                <xsl:value-of
                                        select="concat(@empno,'-',@job,' name:',ename,' birthday:',hiredate,' salary:',sal)"/>
                            </li>
                        </xsl:when>
                    </xsl:choose>
                </xsl:for-each>
            </xsl:for-each>
        </ul>
        <ul>
            <xsl:for-each select="dept">
<!--                <xsl:sort select="emp/sal" data-type="number"/>-->
                <xsl:for-each select="emp">
                    <xsl:sort select="sal" data-type="number"/>
                    <xsl:choose>
                        <xsl:when test="sal>=1000 and sal&lt;3000">
                            <li>
                                <xsl:value-of
                                        select="concat(@empno,'-',@job,' name:',ename,' birthday:',hiredate,' salary:',sal)"/>
                            </li>
                        </xsl:when>
                    </xsl:choose>
                </xsl:for-each>
            </xsl:for-each>
        </ul>
        <ul>
            <xsl:for-each select="dept">
                <xsl:sort select="emp/sal" data-type="number"/>
                <xsl:for-each select="emp">
                    <xsl:choose>
                        <xsl:when test="sal>=3000 and sal&lt;=5000">
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