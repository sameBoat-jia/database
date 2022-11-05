<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/company">
        <ul>
            <xsl:for-each select="dept">
                <li>
                    <xsl:value-of select="concat('no:',@deptno,' name:',@dname,' location:',@loc)"></xsl:value-of>
                </li>
            </xsl:for-each>
        </ul>
    </xsl:template>
</xsl:stylesheet>