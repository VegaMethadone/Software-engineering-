# Крысиный Amazon по мотивам мультфильма "Рататуй"

## Акторы:

1. Менежер Эмиль *(МР)*
2. Папа Крыса *(ПК)*
3. Крыса *(К)*
4. Учитель Рейми *(Р)*
5. Потребитель *(П)*

## Диаграмма последовательности:

```mermaid
sequenceDiagram
    participant МР as Менежер Эмиль
    participant ПК as Папа Крыса
    participant К as Крыса
    participant Р as Учитель Рейми
    participant П as Потребитель
    activate П
    par
        П->>МР: Запрос на крысу с особоыми характеристиками 
    end
    activate МР
    par
        МР->>ПК:Передает информацию о заказе
    end
    activate ПК
    par
        ПК->>Р: Производит крыс и передает их
    end

    note right of П: Есть разные классы крыс: <br>легендарные, мифические,<br> редкие и обычные.<br> Чем реже реже класс встречается,<br>тем он лучше готовит. <br> Потребитель (кулинар) может купить скины <br>для своей крысы <br>при необходимости, чтобы <br>выделиться на фоне <br>других

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
    note right of П: В случае отсутствия надобности <br>в крысе, потребитель отправляет <br>эту крысу домой <br> к папе крысе
    par
        П->>ПК:** Возвращает в случае отсутствия необходимости в крысе**
    end
    note right of П: Потребитель может купить <br> скины для своей крысы <br>при необходимости, <br>чтобы выделиться <br>на фоне других
    par
        П->>МР: Желание кастомизации крысы
        МР->>П: Отправка скинов на крысу
    end
     
```
        
    
    
    
        
        
