<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/company">
        <ul>
            <xsl:for-each select="dept">
                <xsl:if test="starts-with(@deptno,'D10')">
                    <xsl:for-each select="emp">
                        <xsl:if test="starts-with(@job,'MANAGER')">
                            <li>
                                <xsl:value-of
                                        select="concat(@empno,'-',@job,' name:',ename,' birthday:',hiredate,' salary:',sal)"/>
                            </li>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:if>
                <xsl:if test="starts-with(@deptno,'D20')">
                    <xsl:for-each select="emp">
                        <xsl:if test="starts-with(@job,'CLERK')">
                            <li>
                                <xsl:value-of
                                        select="concat(@empno,'-',@job,' name:',ename,' birthday:',hiredate,' salary:',sal)"/>
                            </li>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:if>
            </xsl:for-each>
        </ul>
    </xsl:template>
</xsl:stylesheet>