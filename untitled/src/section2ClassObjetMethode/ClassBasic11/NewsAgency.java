package section2ClassObjetMethode.ClassBasic11;

import section2ClassObjetMethode.ClassBasic11.business11.Compagny;
/*import section2ClassObjetMethode.ClassBasic11.business11.FactoryWorker;*/

/**
 * Section 2 - 11. Class Basics
 */
class NewsAgency { // son but est d'interviewer la Compagnie, mais la NewsAgency n'a pas la permission d'interviewer FactoryWorkers de la Compagnie que le CEO

    Compagny compagny;

    /*FactoryWorker factoryWorker;*/ // si FactoryWorkers et NewsAgency était dans le meme package rien ne nous empecherait d'interviewer FactoryWorkers
}
