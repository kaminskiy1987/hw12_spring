Справка:

localhost:8080/api - полный обзор установки
localhost:8080/api/area - список подсистем установки
localhost:8080/api/area/{index} - описание подсистемы
localhost:8080/api/area/{index}/equip - список оборудования подсистемы
localhost:8080/api/area/{index}/equip/ai - список датчиков подсистемы
localhost:8080/api/area/{index}/equip/di - список сигнализаторов подсистемы
localhost:8080/api/area/{index}/equip/mtr - список эл.моторов подсистемы
localhost:8080/api/area/{index}/equip/vlv - список арматуры подсистемы

Используемые паттерны:
    - Bridge (IMyEquipment) абстракция оборудования и её реализации
    - Factory - для генерации различных типов оборудования участка
    - Composite (Area содержит другие Area) - подсистема оборудования может содержать другие подсистемы, со своим собственным оборудованием
    - Singleton - единый генератор оборудования