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
    par
        П->>МР: Запрос на крысу с особоыми характеристиками 
    end
    note right of П: Есть разные классы крыс: <br>легендарные, мифические,<br> редкие и обычные.<br> Чем реже реже класс встречается,<br>тем он лучше готовит. <br> Потребитель (кулинар) может <br>купить скины для своей<br> крысы при необходимости, <br>чтобы выделиться на <br>фоне других<br>
    activate МР
    par
        МР->>ПК:Передает информацию о заказе
    end
    activate ПК
    par
        ПК->>Р: Производит крыс и передает их
    end
    activate Р
    par 
        Р->>К:Обучние по заданным характеристикам
    end
    par
        К->>МР:Сообщает о готовности 
        МР->>К:Сообщает адрес потребителя
    end
    par
        К->>П: Добирается по водосточной трубе к потребителю
    end
    
    
    
```
        
    
    
    
        
        
