package com.cssolutions.dunzo

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OrganisationChartDriverTest {

    @Test
    fun buildOrganisationChart() {
        OrganisationChartDriver().buildOrganisationChart(lis)
    }
}