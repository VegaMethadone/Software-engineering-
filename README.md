# Крысиный Amazon по мотивам мультфильма "Рататуй"

## Акторы:

1. Менежер Рейми *(МР)*
2. Папа Крыса *(ПК)*
3. Крыса *(К)*
4. Учитель Рейми *(Р)*
5. Потребитель *(П)*

## Диаграмма последовательности:

```mermaid
sequenceDiagram
    participant МР as Менежер Рейми
    participant ПК as Папа Крыса
    participant К as Крыса
    participant Р as Учитель Рейми
    participant П as Потребитель
    activate П
    par П to МР
        П->>МР: Запрос на крысу с особоыми характеристиками
    and МР to ПК
        МР->>ПК: Передает информацию о заказе
    end
    
    
```
        
    
    
    
        
        
