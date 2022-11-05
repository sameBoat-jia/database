<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/company">
        <xsl:for-each select="dept">
            <xsl:if test="starts-with(@deptno,'D30')">
                <ul>
                    <xsl:for-each select="emp">
                        <li>
                            <xsl:value-of
                                    select="concat(@empno,'-',@job,' name:',ename,' birthday:',hiredate,' salary:',sal)"/>
                        </li>
                    </xsl:for-each>
                </ul>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>