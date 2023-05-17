package com.github.kabal163.java.problems.network;

/*
Теперь давайте перейдем к более интересным задачам! Мы создадим с вами модель сети! В нашей с вами модели будут следующие сетевые элементы: PC и Cable. Каждый PC может быть соединен с множеством других PC при помощи кабелей.

Требования:
1. Каждый элемент должен иметь свой идентификатор
2. Каждый PC может быть соединен с множеством других элементов
3. Должна быть возможность получать из PC множество других PC (соседей) к которым он подключен

Визуализация модели сети из примера ниже.
       [1]-----------[2]
        | \         / |
        |  \       /  |
        |   \     /   |
        |     [5]     |
        |   /     \   |
        |  /       \  |
        | /         \ |
       [4]-----------[3]
 */
public class Application {


    public static void main(String[] args) {

        PC pc1 = new PC("172.0.17.1", 3);
        PC pc2 = new PC("172.0.17.2", 3);
        PC pc3 = new PC("172.0.17.3", 3);
        PC pc4 = new PC("172.0.17.4", 3);
        PC pc5 = new PC("172.0.17.5", 4);

        Cable cable1 = new Cable(1);
        Cable cable2 = new Cable(2);
        Cable cable3 = new Cable(3);
        Cable cable4 = new Cable(4);
        Cable cable5 = new Cable(5);
        Cable cable6 = new Cable(6);
        Cable cable7 = new Cable(7);
        Cable cable8 = new Cable(8);

        pc1.connect(cable1);
        pc2.connect(cable1);

        pc2.connect(cable2);
        pc3.connect(cable2);

        pc3.connect(cable3);
        pc4.connect(cable3);

        pc4.connect(cable4);
        pc1.connect(cable4);

        pc1.connect(cable5);
        pc5.connect(cable5);

        pc2.connect(cable6);
        pc5.connect(cable6);

        pc3.connect(cable7);
        pc5.connect(cable7);

        pc4.connect(cable8);
        pc5.connect(cable8);

        System.out.println(pc5.neighbors());
    }
}
