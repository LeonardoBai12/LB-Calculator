package io.lb.lbcalculator.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.lb.lbcalculator.data.repository.CalculatorRepositoryImpl
import io.lb.lbcalculator.domain.repository.CalculatorRepository
import io.lb.lbcalculator.domain.use_cases.CalculatorUseCases
import io.lb.lbcalculator.domain.use_cases.ConversionUseCase
import io.lb.lbcalculator.domain.use_cases.NumberUseCase
import io.lb.lbcalculator.domain.use_cases.OperationUseCase

@Module
@InstallIn(ViewModelComponent::class)
object CalculatorModule {
    @Provides
    fun providesCalculatorRepository(): CalculatorRepository {
        return CalculatorRepositoryImpl()
    }

    @Provides
    fun providesCalculatorUseCases(repository: CalculatorRepository): CalculatorUseCases {
        return CalculatorUseCases(
            numberUseCase = NumberUseCase(repository),
            operationUseCase = OperationUseCase(repository),
            conversionUseCase = ConversionUseCase(repository),
        )
    }
}
