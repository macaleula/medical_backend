<?php

namespace App\Http\Controllers;

use App\DataTables\CategoriaEquipamentoDataTable;
use App\Http\Requests;
use App\Http\Requests\CreateCategoriaEquipamentoRequest;
use App\Http\Requests\UpdateCategoriaEquipamentoRequest;
use App\Repositories\CategoriaEquipamentoRepository;
use Flash;
use App\Http\Controllers\AppBaseController;
use Response;
use Illuminate\Support\Facades\DB;

class CategoriaEquipamentoController extends AppBaseController
{
    /** @var  CategoriaEquipamentoRepository */
    private $categoriaEquipamentoRepository;

    public function __construct(CategoriaEquipamentoRepository $categoriaEquipamentoRepo)
    {
        $this->categoriaEquipamentoRepository = $categoriaEquipamentoRepo;
    }

    /**
     * Display a listing of the CategoriaEquipamento.
     *
     * @param CategoriaEquipamentoDataTable $categoriaEquipamentoDataTable
     * @return Response
     */
    public function index(CategoriaEquipamentoDataTable $categoriaEquipamentoDataTable)
    {
        return $categoriaEquipamentoDataTable->render('categoria_equipamentos.index');
    }

    /**
     * Show the form for creating a new CategoriaEquipamento.
     *
     * @return Response
     */
    public function create()
    {
        return view('categoria_equipamentos.create');
    }

    /**
     * Store a newly created CategoriaEquipamento in storage.
     *
     * @param CreateCategoriaEquipamentoRequest $request
     *
     * @return Response
     */
    public function store(CreateCategoriaEquipamentoRequest $request)
    {
        $input = $request->all();

        $categoriaEquipamento = $this->categoriaEquipamentoRepository->create($input);

        Flash::success('Categoria Equipamento saved successfully.');

        return redirect(route('categoriaEquipamentos.index'));
    }

    /**
     * Display the specified CategoriaEquipamento.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function show($id)
    {
        $categoriaEquipamento = $this->categoriaEquipamentoRepository->find($id);

        if (empty($categoriaEquipamento)) {
            Flash::error('Categoria Equipamento not found');

            return redirect(route('categoriaEquipamentos.index'));
        }

        return view('categoria_equipamentos.show')->with('categoriaEquipamento', $categoriaEquipamento);
    }

    /**
     * Show the form for editing the specified CategoriaEquipamento.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function edit($id)
    {
        $categoriaEquipamento = $this->categoriaEquipamentoRepository->find($id);

        if (empty($categoriaEquipamento)) {
            Flash::error('Categoria Equipamento not found');

            return redirect(route('categoriaEquipamentos.index'));
        }

        return view('categoria_equipamentos.edit')->with('categoriaEquipamento', $categoriaEquipamento);
    }

    /**
     * Update the specified CategoriaEquipamento in storage.
     *
     * @param  int              $id
     * @param UpdateCategoriaEquipamentoRequest $request
     *
     * @return Response
     */
    public function update($id, UpdateCategoriaEquipamentoRequest $request)
    {
        $categoriaEquipamento = $this->categoriaEquipamentoRepository->find($id);

        if (empty($categoriaEquipamento)) {
            Flash::error('Categoria Equipamento not found');

            return redirect(route('categoriaEquipamentos.index'));
        }

        $categoriaEquipamento = $this->categoriaEquipamentoRepository->update($request->all(), $id);

        Flash::success('Categoria Equipamento updated successfully.');

        return redirect(route('categoriaEquipamentos.index'));
    }

    /**
     * Remove the specified CategoriaEquipamento from storage.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function destroy($id)
    {
        $categoriaEquipamento = $this->categoriaEquipamentoRepository->find($id);

        if (empty($categoriaEquipamento)) {
            Flash::error('Categoria Equipamento not found');

            return redirect(route('categoriaEquipamentos.index'));
        }

        $this->categoriaEquipamentoRepository->delete($id);

        Flash::success('Categoria Equipamento deleted successfully.');

        return redirect(route('categoriaEquipamentos.index'));
    }

    public function undelete($id)
    {
        $categoriaEquipamento = DB::table('categoria_equipamento')
		    ->where('id', $id)->first();

        if (empty($categoriaEquipamento)) {
            Flash::error('Categoria Equipamento not found');

            return redirect(route('categoriaEquipamentos.index'));
        }

	    DB::table('categoria_equipamento')
		    ->where('id', $id)
		    ->update(array('deleted_at' => null));

        Flash::success('Categoria Equipamento undeleted successfully.');

        return redirect(route('categoriaEquipamentos.index'));
    }

    public function datatableAjax()
    {
	    $lista = DB::table('categoria_equipamento')
		    ->select(
				'categoria_equipamento.*'
				)
			->get();
	    return $lista;
    }
}
